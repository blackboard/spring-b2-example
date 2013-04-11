package blackboard.plugin.springdemo.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Annotates any class as a web controller
@Controller
public class HelloWorldController
{

  // Annotates a specific method for handling a web request
  @RequestMapping( "/helloWorld" )
  public String helloWorld( )
  {
    // simply returns the name of the JSP file to render
    return "hello_world";
  }

}
