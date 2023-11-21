package com.project.enjoytrip.bookmark.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
public class Bookmark {
    @Id
    private BookmarkId id;
}
