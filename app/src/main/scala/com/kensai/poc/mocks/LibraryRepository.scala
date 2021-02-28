package com.kensai.poc.mocks

import java.util.UUID

trait LibraryRepository {

  def countBooks: Long

  def getById(id: UUID): Option[Book]

  def getAll: Seq[Book]
}

class DefaultLibraryRepository(private val books: Map[UUID, Book]) extends LibraryRepository {

  @Override
  def countBooks: Long =
    books.size

  @Override
  def getById(id: UUID): Option[Book] =
    books.get(id)

  @Override
  def getAll: Seq[Book] =
    books.values.toSeq

}
