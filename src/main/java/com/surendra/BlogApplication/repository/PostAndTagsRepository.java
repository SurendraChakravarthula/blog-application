package com.surendra.BlogApplication.repository;

import com.surendra.BlogApplication.model.PostAndTag;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PostAndTagsRepository extends JpaRepository<PostAndTag, Long> {
    @Query("DELETE FROM PostAndTag pt WHERE pt.post.id = :id")
    @Transactional
    @Modifying
    void deletePostAndTag(long id);
}
