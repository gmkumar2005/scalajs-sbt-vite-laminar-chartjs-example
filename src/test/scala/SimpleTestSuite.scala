//import munit.FunSuite
//
//class SimpleTestSuite extends FunSuite {
//
//  test("lists of chars") {
//    val expected = List('h', 'e', 'l', 'l', 'o')
//    // val actual = List('h', 'e', 'l', 'l', '0')
//    val actual = List('h', 'e', 'l', 'l', 'o')
//    assertEquals(actual, expected)
//  }
//}

import org.scalajs.dom
import org.scalatest.*
import org.scalatest.flatspec.*
import org.scalatest.matchers.*

import scala.collection.mutable.Stack

class SimpleTestSuite extends AnyFlatSpec with should.Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should be(2)
    stack.pop() should be(1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[Int]
    a[NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }
  }

  it should "Create a h1 dom element" in {
    val h1 = dom.document.createElement("h1")
    h1.textContent = "Hello World"
    dom.document.body.appendChild(h1)
    val h1s = dom.document.getElementsByTagName("h1")
    h1s.length should be(1)
    h1s.item(0).textContent should be("Hello World")

  }
}
