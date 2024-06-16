package com.titgroup.myFirstProject;

//@RestController
//@Controller
//public class myClass {
//    @GetMapping("abc")
//    @ResponseBody
//    public String sayHello(){
//        return "Welcome Ajay Nice";
//    }
//
//}

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myClass{
    @GetMapping("own")
    public String ownFunction(){
        String import2 = "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">";
        String first = "<div class=\"alert alert-primary\" role=\"alert\">\n" +
                "  A simple primary alert—check it out!\n" +
                "</div>\n" +
                "<div class=\"alert alert-secondary\" role=\"alert\">\n" +
                "  A simple secondary alert—check it out!\n" +
                "</div>\n" +
                "<div class=\"alert alert-success\" role=\"alert\">\n" +
                "  A simple success alert—check it out!\n" +
                "</div>\n" +
                "<div class=\"alert alert-danger\" role=\"alert\">\n" +
                "  A simple danger alert—check it out!\n" +
                "</div>\n" +
                "<div class=\"alert alert-warning\" role=\"alert\">\n" +
                "  A simple warning alert—check it out!\n" +
                "</div>\n" +
                "<div class=\"alert alert-info\" role=\"alert\">\n" +
                "  A simple info alert—check it out!\n" +
                "</div>\n" +
                "<div class=\"alert alert-light\" role=\"alert\">\n" +
                "  A simple light alert—check it out!\n" +
                "</div>\n" +
                "<div class=\"alert alert-dark\" role=\"alert\">\n" +
                "  A simple dark alert—check it out!\n" +
                "</div>";
        String linked = "<iframe src=\"https://www.linkedin.com/embed/feed/update/urn:li:ugcPost:7206132999057203201\" height=\"1930\" width=\"504\" frameborder=\"0\" allowfullscreen=\"\" title=\"Embedded post\"></iframe>";
        return import2 + first + linked;
    }
}