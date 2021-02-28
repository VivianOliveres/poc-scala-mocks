package com.kensai.poc.mocks

import java.util.UUID

object App {

  def main(args: Array[String]): Unit = {
    val books = Map(
      generateBookEntry("Programming in Scala", 547),
      generateBookEntry("Effective Java", 412),
      generateBookEntry("Head First Design Patterns", 376)
    )

    val repo = new DefaultLibraryRepository(books)
    println(s"Books available: ${repo.countBooks}")

    val service = new DefaultLibraryService(repo)
  }

  def generateBookEntry(title: String, pages: Long): (UUID, Book) = {
    val id = UUID.randomUUID()
    (id, Book(id, title, pages))
  }

}
