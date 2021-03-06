package com.neo4j.demo.service;

import com.neo4j.demo.entity.Painting;
import com.neo4j.demo.repository.PaintingRepository;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaintingService {
    @Resource
    private PaintingRepository repository;

    public List<Painting> findPaintings() {
        return repository.findPaintings();
    }

    public List<Painting> findPaintings(int limit) {
        return repository.findLimitPaintings(limit);
    }

    public Painting findPaintingById(Long id) {
        return repository.findPaintingById(id);
    }

    public List<Painting> findRelatedPaintings(Long id) {
        return repository.findRelatedPaintingsById(id);
    }

    public Painting savePaintingDescription(Long id, String description) {
        return repository.savePaintingDescription(id, description);
    }

    public List<Painting> findPaintingByName(String name) {
        return repository.findPaintingByName(name);
    }

}
