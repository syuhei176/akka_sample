import akka.actor.{ ActorSystem, Actor, ActorRef, Props, PoisonPill }

class HelloActor extends Actor {
  def receive = { 
    case i:Int => println("Int=" + i)
    case msg => { 
      println("any=" + msg)
      sender() ! ("Hello," + msg.toString)
    }
  }
}

object Main extends App {

  val system = ActorSystem("helloworld")
  val helloActor = system.actorOf(Props[HelloActor], "hello")
  
  val result1 = helloActor ! 100
  val result2 = helloActor ! "World"
  println("result1 = " + result1)
  println("result2 = " + result1)
 
   
}