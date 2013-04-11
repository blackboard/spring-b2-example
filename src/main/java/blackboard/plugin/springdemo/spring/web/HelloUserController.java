package blackboard.plugin.springdemo.spring.web;

import blackboard.data.user.User;
import blackboard.platform.spring.beans.annotations.ContextValue;
import blackboard.platform.spring.beans.annotations.UserAuthorization;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloUserController
{

  @RequestMapping( "/hello" )
  @UserAuthorization( "system.plugin.MODIFY" )
  public ModelAndView hello( @ContextValue User user )
  {
    // ModelAndView objects encapsulate the data for a view and which view to show in one
    ModelAndView mv = new ModelAndView( "hello" );
    
    // Objects can be added tot he model for use in the JSP view
    mv.addObject( "user", ( user != null ? user.getUserName() : "guest" ) );
    
    return mv;
  }

}
