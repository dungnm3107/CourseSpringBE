package com.example.course_be.service;

import com.example.course_be.request.chapter.ChapterRequest;
import com.example.course_be.request.chapter.ChapterUpdateRequest;

public interface ChapterService {

    String saveChapter(ChapterRequest chapterRequest);

    String updateChapter(ChapterUpdateRequest chapterUpdateRequest);
}
