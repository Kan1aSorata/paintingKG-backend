package com.neo4j.demo.util;

import com.neo4j.demo.domain.ChartData;
import com.neo4j.demo.entity.Painting;
import com.neo4j.demo.repository.PainterRepository;
import com.neo4j.demo.repository.PaintingRepository;

import javax.annotation.Resource;
import java.util.List;

public class NodeUtil {
    @Resource
    private PainterRepository painterRepository;
    @Resource
    private PaintingRepository paintingRepository;

    public static ChartData convert2ChartData(List<Painting> paintings) {
        //TODO 将list转换为chartData
    }
}
