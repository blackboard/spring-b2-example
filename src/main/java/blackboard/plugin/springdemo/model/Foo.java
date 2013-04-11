package blackboard.plugin.springdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "bb_springdemo_foo" )
public class Foo
{

  private Long id;
  private String name;
  private String value;

  @Id
  @GeneratedValue( strategy=GenerationType.AUTO, generator="bb_springdemo_foo_seq" )
  @SequenceGenerator( name="bb_springdemo_foo_seq", sequenceName="bb_springdemo_foo_seq" )
  @Column( name = "foo_id" )
  public Long getId()
  {
    return id;
  }

  public void setId( Long id )
  {
    this.id = id;
  }

  @Column( name = "name" )
  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

  @Column( name = "value" )
  public String getValue()
  {
    return value;
  }

  public void setValue( String value )
  {
    this.value = value;
  }

}
