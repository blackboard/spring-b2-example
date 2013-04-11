package blackboard.plugin.springdemo.spring.web;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import blackboard.plugin.springdemo.model.Foo;

@Controller
public class HelloFooJPAController
{

  // EM factory reference for our code
  @Autowired
  private EntityManagerFactory _entityManagerFactory;

  @RequestMapping( "/fooJPAController" )
  public ModelAndView helloFoo( @RequestParam( value = "n", required = false ) String name,
                                @RequestParam( value = "v", required = false ) String value ) throws Exception
  {
    if ( name != null && value != null )
    {
      // let's create a Foo object
      Foo f = new Foo();
      f.setName( name );
      f.setValue( value );

      // create an entity manager
      EntityManager em = _entityManagerFactory.createEntityManager();
      EntityTransaction tx = em.getTransaction();

      try
      {
        // save the Foo to the database
        tx.begin();
        em.persist( f );
        tx.commit();
      }
      catch ( Exception err )
      {
        tx.rollback();
        throw err;
      }
      finally
      {
        em.close();
      }
    }

    // now load the Foo's
    EntityManager em = _entityManagerFactory.createEntityManager();
    Query q = em.createQuery( "from Foo" );

    @SuppressWarnings( "unchecked" )
    List<Foo> l = q.getResultList();
    em.close();

    // pass the list back to the JSP view
    ModelAndView mv = new ModelAndView( "foo_jpa" );
    mv.addObject( "fooList", l );
    return mv;
  }

}
