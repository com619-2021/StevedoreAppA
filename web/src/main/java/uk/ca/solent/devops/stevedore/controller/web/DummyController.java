package uk.ca.solent.devops.stevedore.controller.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.ca.solent.devops.stevedore.service.TestService;

@Controller
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class DummyController {

    private final TestService testService;

    public DummyController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    String getHome(Model model) {
        model.addAttribute("name", "Julian");
        model.addAttribute("role", "Admin");
        model.addAttribute("tests", testService.getAllTest());
        return "test";
    }

}
