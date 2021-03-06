package com.neo4j.demo.controller;

import com.neo4j.demo.domain.ChartData;
import com.neo4j.demo.entity.Painting;
import com.neo4j.demo.service.PainterService;
import com.neo4j.demo.service.PaintingService;
import com.neo4j.demo.util.NodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "对知识图谱的crud", tags = "查询画家或画作")
@CrossOrigin
public class PaintKGController {
    @Resource
    private PainterService painterService;
    @Resource
    private PaintingService paintingService;

    /**
     * 返回最近的5个Node
     * @param type 1:画家,2:画作
     * @return 5个Node
     */
    @ApiOperation(value = "返回最近的5个Node",notes = "用type指定返回类型 1:画家,2:画作")
    @RequestMapping(value = "/type", headers = "type", method = RequestMethod.GET)
    public List recentNode(
                @ApiParam(name = "type", value = "类型,1:画家,2:画作")
            @RequestHeader("type") int type) {
        return type==1? painterService.findPainters() : paintingService.findPaintings();
    }

    /**
     * 返回最近的limit个Node
     * @param type 类型,1:画家,2:画作
     * @param limit 限制的条数
     * @return limit个Node
     */
        @ApiOperation(value = "返回最近的limit个Node",notes = "用type指定返回类型 1:画家,2:画作")
    @RequestMapping(value = "/type-limit", headers = "type", method = RequestMethod.GET)
    public List recentLimitedNode(
                @ApiParam(name = "type", value = "类型,1:画家,2:画作")
            @RequestHeader("type") int type,
                @ApiParam(name = "limit", value = "限制的条数")
            @RequestHeader("limit") int limit) {
        return type ==1? painterService.findPainters(limit) : paintingService.findPaintings(limit);
    }


    /**
     * 用id查找节点，type确定类型
     * @param type 类型 1画家2画作
     * @param id 节点id
     * @return 节点
     */
        @ApiOperation(value = "用id查找节点，type确定类型")
    @RequestMapping(value = "/type-id", method = RequestMethod.GET)
    public Object findNodeById(

                @ApiParam(name = "type", value = "1画家2画作")
            @RequestHeader("type") int type,

                @ApiParam(name = "id", value = "节点id")
            @RequestHeader("id") Long id) {
        return type==1? painterService.findPainterById(id) : paintingService.findPaintingById(id);
    }

    @RequestMapping(value = "/type-name", method = RequestMethod.GET)
    public Object findNodeByName(
            @RequestParam("type") int type,
            @RequestParam("name") String name) {
            return type == 1? painterService.findPainterByName(name) : paintingService.findPaintingByName(name);
    }

    /**
     * 通过id查找节点及其相关的所有节点
     * @param type 类型 1画家2画作
     * @param id 节点id
     * @return 节点集合的json
     */
    @ApiOperation(value = "通过id查找节点及其相关的所有节点")
    @RequestMapping(value = "/id-graph", method = RequestMethod.GET)
    public ChartData findGraphById(@RequestParam("type") int type, @RequestParam("id") Long id) {
        return type == 1?
                NodeUtil.convert2ChartData(painterService.findRelatedPainters(id), painterService.findRelatedPaintings(id)):
                NodeUtil.convert2ChartData(paintingService.findRelatedPaintings(id));
    }


    @RequestMapping(value = "/add-painting-des", method = RequestMethod.POST)
    public Painting addPaintingDescription(@RequestParam("id") Long id,
                                           @RequestParam("des") String des) {
        return paintingService.savePaintingDescription(id, des);
    }

    @RequestMapping(value = "/made-list",method = RequestMethod.GET)
    public List<Painting> getMadeList(@RequestParam("id") Long id) {
        return painterService.findRelatedPaintings(id);
    }

}
