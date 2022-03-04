package com.neo4j.demo.util;

import com.neo4j.demo.domain.ChartData;
import com.neo4j.demo.domain.Link;
import com.neo4j.demo.domain.Node;
import com.neo4j.demo.domain.Style;
import com.neo4j.demo.entity.Painter;
import com.neo4j.demo.entity.Painting;
import java.util.ArrayList;
import java.util.List;

public class NodeUtil {
    public static ChartData convert2ChartData(List<Painting> paintings) {
        List<Node> nodes = new ArrayList<>();
        List<Link> links = new ArrayList<>();

        Long oriId = paintings.get(0).getId();
        for (Painting paint :
                paintings) {
            Node node = Node.builder().id(paint.getId()).name(paint.getName()).build();
            node.setStyle(Style.builder().image(paint.getPicture()).build());
            nodes.add(node);
        }
        for (Painting paint :
                paintings) {
            Link link = Link.builder().from(oriId).to(paint.getId()).text("相同博物馆").build();
            links.add(link);
            if (link.getTo().equals(oriId))
                links.remove(link);
        }
        return ChartData.builder().nodes(nodes).links(links).build();
    }

    public static ChartData convert2ChartData(List<Painter> painters, List<Painting> paintings) {
        List<Node> nodes = new ArrayList<>();
        List<Link> links = new ArrayList<>();

        Long oriId = painters.get(0).getId();
        for (Painter painter :
                painters) {
            Node node = Node.builder().id(painter.getId()).name(painter.getName()).build();
            node.setStyle(Style.builder().image(painter.getImage()).build());
            nodes.add(node);
            Link link = Link.builder().from(oriId).to(painter.getId()).text("同一时期").build();
            links.add(link);
        }
        for (Painting painting :
                paintings) {
            Node node = Node.builder().id(painting.getId()).name(painting.getName()).build();
            node.setStyle(Style.builder().image(painting.getPicture()).build());
            nodes.add(node);
            Link link = Link.builder().from(oriId).to(painting.getId()).text("相同作者").build();
            links.add(link);
        }
        return ChartData.builder().nodes(nodes).links(links).build();
    }
}
