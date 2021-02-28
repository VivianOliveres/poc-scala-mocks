package com.kensai.poc.mocks

import org.junit.runner.RunWith
import org.scalamock.scalatest.MockFactory
import org.scalatest.GivenWhenThen
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatestplus.junit.JUnitRunner
import org.scalatest.matchers.should.Matchers._

import java.util.UUID

@RunWith(classOf[JUnitRunner])
class ScalaMockLibraryServiceSuite extends AnyFlatSpec with GivenWhenThen with MockFactory {

  val repo: LibraryRepository = mock[LibraryRepository]

  val service = new DefaultLibraryService(repo)

  "findBiggerBook" should "return None when there is no books in repo" in {
    Given("Repo is empty")
    (repo.getAll _).expects().returns(Seq())

    When("findBiggerBook")
    val result = service.findBiggerBook

    Then("Result is None")
    result shouldBe None
  }

  "findBiggerBook" should "return expected results" in {
    Given("Repo contains two books")
    val book1 = Book(UUID.randomUUID(), "Programming in Scala", 547)
    val book2 = Book(UUID.randomUUID(), "Effective Java", 412)
    (repo.getAll _).expects().returns(Seq(book1, book2))

    When("findBiggerBook")
    val result = service.findBiggerBook

    Then("Result is book1")
    result shouldBe Some(book1)
  }

}
