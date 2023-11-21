package com.project.enjoytrip.bookmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.enjoytrip.bookmark.entity.Bookmark;
import com.project.enjoytrip.bookmark.entity.BookmarkId;

public interface BookmarkRepositorty extends JpaRepository<Bookmark, BookmarkId> {

}
