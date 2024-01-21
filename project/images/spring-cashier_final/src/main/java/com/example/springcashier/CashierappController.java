package com.example.springcashier;

import com.example.springcashier.order.Order;
import com.example.springcashier.order.OrderData;
import com.example.springcashier.order.OrderDataRepository;
import com.example.springcashier.redis.RegistrationForm;
import com.example.springcashier.user.UserData;
import com.example.springcashier.user.UserDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.InetAddress;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class CashierappController {

    private final OrderDataRepository orderDataRepository;
    private final UserDataRepository userDataRepository;

    @Autowired
    public CashierappController(OrderDataRepository orderDataRepository, UserDataRepository userDataRepository) {
        this.orderDataRepository = orderDataRepository;
        this.userDataRepository = userDataRepository;
    }

    @GetMapping("/")
    public String getAction(@ModelAttribute("command") Command command,
                            Model model, HttpSession session) {

        String message;
        String apiStr = "";
        String resourceUrl = "";
        RestTemplate restTemplate = new RestTemplate();
        command.setRegister("5012349");
        message = "Starbucks Reserved Order" + "\n\n" +
                "Register: " + command.getRegister() + "\n" +
                "Status:   " + "Ready for New Order" + "\n";


        String server_ip = "";
        String host_name = "";
        try {
            InetAddress ip = InetAddress.getLocalHost();
            server_ip = ip.getHostAddress();
            host_name = ip.getHostName();
        } catch (Exception e) {
            log.error("Error occurred while retrieving server IP and host name.", e);
        }

        model.addAttribute("message", message);
        model.addAttribute("server", host_name + "/" + server_ip);

        return "starbucksCashier";

    }

    @PostMapping("/")
    public String postAction(@Valid @ModelAttribute("command") Command command,
                             @RequestParam(value = "action", required = true) String action,
                             Errors errors, Model model, HttpServletRequest request, HttpSession session,
                             @RequestParam("drink") String drink, @RequestParam("size") String size,
                             @RequestParam("milk") String milk) {

        String message = null;
        String apiStr = "";
        String resourceUrl = "";
        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", "Zkfokey2311");
        RestTemplate restTemplate = new RestTemplate();
        log.info("Action: " + action);
        command.setRegister(command.getStores());
        log.info("Command: " + command);

        /* Process Post Action */
        if (action.equals("Place Order")) {
            Order order = Order.GetNewOrder(drink, milk, size);
            order.setRegister(command.getRegister());
            String orderRegister = command.getRegister();
            resourceUrl = "http://34.30.75.35/api/order/register/5012349";
            List<OrderData> orders = getRegisterOrders(orderRegister);
            Order orderRequest = new Order();

            if (orders.isEmpty()) {
                if (order.getDrink().equals("Espresso") && order.getSize().equals("Venti")) {
                    message = "Espresso don't have Venti size";
                } else {
                    message = "Starbucks Reserved Order" + "\n\n" +
                            "Drink: " + order.getDrink() + "\n" +
                            "Milk:  " + order.getMilk() + "\n" +
                            "Size:  " + order.getSize() + "\n" +
                            "Total: " + order.getTotal() + "\n" +
                            "\n" +
                            "Register: " + order.getRegister() + "\n" +
                            "Status:   " + order.getStatus() + "\n";

                    addNewOrder(order.getDrink(), order.getMilk(), order.getSize(), order.getTotal(), order.getStatus(), order.getRegister());
                    orderRequest.setDrink(order.getDrink());
                    orderRequest.setMilk(order.getMilk());
                    orderRequest.setSize(order.getSize());

                    HttpEntity<Order> newOrderRequest = new HttpEntity<Order>(orderRequest, headers);
                    ResponseEntity<Order> newOrderResponse = restTemplate.postForEntity(resourceUrl, newOrderRequest, Order.class);
                    Order newOrder = newOrderResponse.getBody();
                    log.info(newOrder.toString());
                    try {
                        ObjectMapper objectMapper = new ObjectMapper();
                        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(newOrder);
                        log.info(jsonString);
                        apiStr = "\n" + jsonString;
                        log.info(apiStr);
                    } catch (Exception e) {
                        log.error("Error occurred while processing new order response.", e);
                    }
                }
            } else {
                log.info("This is an activate order");
                message = "There is an activate order";
            }
        } else if (action.equals("Get Order")) {
            String orderRegister = command.getRegister();
            List<OrderData> orders = getRegisterOrders(orderRegister);
            resourceUrl = "http://34.30.75.35/api/order/register/5012349?apikey={api_key}";

            Order orderInfo = new Order();
            ResponseEntity<Order> updateResponse = restTemplate.getForEntity(resourceUrl, Order.class, "Zkfokey2311");
            orderInfo = updateResponse.getBody();
            Order newOrder = updateResponse.getBody();
            log.info(newOrder.toString());
            String newStatus = newOrder.getStatus();

            log.info("===========");
            log.info("This is new order status: " + newStatus);
            log.info("============");

            if (orders.isEmpty()) {
                message = "There is no an activate order in this store, please place an order";
            } else {
                orders.get(0).setStatus(newStatus);    // update the order status information
                orderDataRepository.save(orders.get(0));  // update MySQL order status information
                message = "Starbucks Reserved Order" + "\n\n" +
                        "Drink: " + orders.get(0).getDrink() + "\n" +
                        "Milk:  " + orders.get(0).getMilk() + "\n" +
                        "Size:  " + orders.get(0).getSize() + "\n" +
                        "Total: " + orders.get(0).getTotal() + "\n" +
                        "Register: " + command.getRegister() + "\n" +
                        "Status:   " + orders.get(0).getStatus() + "\n";
            }
        } else if (action.equals("Clear Order")) {
            String orderRegister = command.getRegister();
            List<OrderData> orders = getRegisterOrders(orderRegister);
            String url = "http://34.30.75.35/api/orders" + "?apikey={api_key}";
            HttpEntity<String> entity = new HttpEntity<>(headers);
            if (orders.isEmpty()) {
                message = "There is no an activate order in this store, please place an order";
            } else {
                ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class, "Zkfokey2311");
                log.info(response.toString());

                orderDataRepository.delete(orders.get(0));
                message = "Starbucks Reserved Order" + "\n\n" +
                        "Register: " + command.getRegister() + "\n" +
                        "Status:   " + "Ready for New Order" + "\n";
                log.info("Data deleted");
            }
        } else if (action.equals("Logout")) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null) {
                new SecurityContextLogoutHandler().logout(request, null, authentication);
            }
            return "redirect:/logout";
        }
        command.setMessage(message);

        String server_ip = "";
        String host_name = "";
        try {
            InetAddress ip = InetAddress.getLocalHost();
            server_ip = ip.getHostAddress();
            host_name = ip.getHostName();
        } catch (Exception e) {
            log.error("Error occurred while retrieving server IP and host name.", e);
        }

        model.addAttribute("message", message);
        model.addAttribute("server", host_name + "/" + server_ip);

        return "starbucksCashier";
    }

    @ResponseBody
    public String addNewOrder(@RequestParam String drink, @RequestParam String milk, @RequestParam String size, @RequestParam String total, @RequestParam String status, @RequestParam String register) {
        OrderData data = new OrderData();
        data.setDrink(drink);
        data.setMilk(milk);
        data.setSize(size);
        data.setTotal(total);
        data.setStatus(status);
        data.setRegister(register);
        orderDataRepository.save(data);

        return "Save Complete";
    }

    @ResponseBody
    public List<OrderData> getRegisterOrders(String register) {
        return (List<OrderData>) orderDataRepository.findByRegister(register);
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model, HttpSession session) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@Valid @ModelAttribute("registrationForm") RegistrationForm registrationForm,
                                          Errors errors, RedirectAttributes attributes, HttpSession session) {
        UserData userData = new UserData();

        if (errors.hasErrors()) {
            return "register";
        }

        String username = registrationForm.getUsername();
        String password = registrationForm.getPassword();
        String confirmPass = registrationForm.getConfirmPassword();

        if (password.equals(confirmPass)) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(password);
            userData.setUsername(username);
            userData.setPassword(encodedPassword);
            userDataRepository.save(userData);
        } else {
            attributes.addAttribute("error", true);
            return "redirect:/register";
        }

        return "redirect:/login";
    }
}
