package com.bookstore.springtest.repository;

import com.bookstore.springtest.entity.Tag;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagRepository extends Neo4jRepository<Tag,Long> {
    @Query("MATCH (t:tag {name: $tag })-[r:relative]->(tags) RETURN tags")
    List<Tag> getTagsWithTwoRelation(String tag);
}
