package com.mihneacristian.project_tracker.Controller;
import com.mihneacristian.project_tracker.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainPageController {

    @RequestMapping({"", "/", "main_page", "main_page.html"})
    public String index() {
        return "main_page";
    }
}
