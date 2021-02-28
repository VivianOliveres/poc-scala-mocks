package com.kensai.poc.mocks

trait LibraryService {
  def findBiggerBook: Option[Book]
}

class DefaultLibraryService(private val repo: LibraryRepository) extends LibraryService {

  @Override
  def findBiggerBook: Option[Book] = {
    val books = repo.getAll
    if (books.isEmpty)
      None
    else
      Some(books.maxBy(_.pages))
  }
}
