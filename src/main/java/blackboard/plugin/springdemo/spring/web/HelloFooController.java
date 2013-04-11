package blackboard.plugin.springdemo.spring.web;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import blackboard.plugin.springdemo.model.Foo;

@Controller
public class HelloFooController
{

  // Session factory reference for our code
  @Autowired
  private SessionFactory _sessionFactory;
  
  @RequestMapping("/fooController")
  public ModelAndView helloFoo(@RequestParam(value="n", required=false) String name, @RequestParam(value="v", required=false) String value) throws Exception
  {
    if (name != null && value != null)
    {
      // let's create a Foo object
      Foo f = new Foo();
      f.setName( name );
      f.setValue( value );
      
      // create a session and transaction
      Session s = _sessionFactory.openSession();
      Transaction tx = null;
      
      try
      {
        tx = s.beginTransaction();
        
        // save the Foo to the database
        s.save( f );
        tx.commit();
      }
      catch (Exception err)
      {
        tx.rollback();
        throw err;
      }
      finally
      {
        s.close();
      }
    }
    
    // now load the Foo's
    Session s = _sessionFactory.openSession();
    Query q = s.createQuery( "from Foo" );
    
    @SuppressWarnings( "unchecked" )
    List<Foo> l = q.list();
    s.close();
    
    // pass the list back to the JSP view
    ModelAndView mv = new ModelAndView("foo");
    mv.addObject( "fooList", l );
    return mv;
  }
  
}
