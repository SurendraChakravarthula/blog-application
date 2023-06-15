package com.surendra.BlogApplication.repository;

import com.surendra.BlogApplication.model.Tag;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<Tag, Long> {
    Tag findByName(String name);

    @Query("DELETE FROM Tag t WHERE NOT EXISTS (SELECT pt FROM PostAndTag pt WHERE pt.tag.id = t.id)")
    @Modifying
    @Transactional
    void deleteUnusedTags();
}
