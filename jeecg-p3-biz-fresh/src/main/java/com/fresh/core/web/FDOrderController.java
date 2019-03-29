package com.fresh.core.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fresh.core.dao.FDQueryDao;
import com.fresh.core.entity.FDGoodsEntity;
import com.fresh.core.entity.FDOrderEntity;
import com.fresh.core.entity.FDStoreEntity;
import com.fresh.core.entity.FDStoreItemsEntity;
import com.fresh.core.model.BadInfo;
import com.fresh.core.model.DateVo;
import com.fresh.core.model.DeliverVo;
import com.fresh.core.model.OrderBackResult;
import com.fresh.core.model.OrderBadTemResult;
import com.fresh.core.model.OrderCountResult;
import com.fresh.core.model.StoreVo;
import com.fresh.core.service.FDOrderService;

import net.sf.json.JSONObject;

/**
 * 描述：订单表
 * 
 * @author: www.jeecg.org
 * @since：2019年03月28日 18时39分50秒 星期四
 * @version:1.0
 */
@Controller
@RequestMapping("/fresh/fDOrder")
public class FDOrderController extends BaseController {
  @Autowired
  private FDOrderService fDOrderService;
  @Resource
  private FDQueryDao fDQueryDao;

  /**
   * 列表页面
   * 
   * @return
   */
  @RequestMapping(params = "list", method = {RequestMethod.GET, RequestMethod.POST})
  public void list(@ModelAttribute FDOrderEntity query, HttpServletRequest request,
      HttpServletResponse response,
      @RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
      @RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize)
      throws Exception {
    try {
      LOG.info(request, " back list");
      // 分页数据
      MiniDaoPage<FDOrderEntity> list = fDOrderService.getAll(query, pageNo, pageSize);
      VelocityContext velocityContext = new VelocityContext();
      velocityContext.put("fDOrder", query);
      velocityContext.put("pageInfos", SystemTools.convertPaginatedList(list));
      String viewName = "fresh/core/fDOrder-list.vm";
      ViewVelocity.view(request, response, viewName, velocityContext);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 详情
   * 
   * @return
   */
  @RequestMapping(params = "toDetail", method = RequestMethod.GET)
  public void fDOrderDetail(@RequestParam(required = true, value = "id") String id,
      HttpServletResponse response, HttpServletRequest request) throws Exception {
    VelocityContext velocityContext = new VelocityContext();
    String viewName = "fresh/core/fDOrder-detail.vm";
    FDOrderEntity fDOrder = fDOrderService.get(id);
    velocityContext.put("fDOrder", fDOrder);
    ViewVelocity.view(request, response, viewName, velocityContext);
  }

  /**
   * 跳转到添加页面
   * 
   * @return
   */
  @RequestMapping(params = "toAdd", method = {RequestMethod.GET, RequestMethod.POST})
  public void toAddDialog(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    VelocityContext velocityContext = new VelocityContext();
    String viewName = "fresh/core/fDOrder-add.vm";
    ViewVelocity.view(request, response, viewName, velocityContext);
  }

  /**
   * 保存信息
   * 
   * @return
   */
  @RequestMapping(params = "doAdd", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody
  public AjaxJson doAdd(@ModelAttribute FDOrderEntity fDOrder) {
    AjaxJson j = new AjaxJson();
    try {
      fDOrderService.insert(fDOrder);
      j.setMsg("保存成功");
    } catch (Exception e) {
      j.setSuccess(false);
      j.setMsg("保存失败");
      e.printStackTrace();
    }
    return j;
  }

  /**
   * 跳转到编辑页面
   * 
   * @return
   */
  @RequestMapping(params = "toEdit", method = RequestMethod.GET)
  public void toEdit(@RequestParam(required = true, value = "id") String id,
      HttpServletResponse response, HttpServletRequest request) throws Exception {
    VelocityContext velocityContext = new VelocityContext();
    FDOrderEntity fDOrder = fDOrderService.get(id);
    velocityContext.put("fDOrder", fDOrder);
    String viewName = "fresh/core/fDOrder-edit.vm";
    ViewVelocity.view(request, response, viewName, velocityContext);
  }

  /**
   * 编辑
   * 
   * @return
   */
  @RequestMapping(params = "doEdit", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody
  public AjaxJson doEdit(@ModelAttribute FDOrderEntity fDOrder) {
    AjaxJson j = new AjaxJson();
    try {
      fDOrderService.update(fDOrder);
      j.setMsg("编辑成功");
    } catch (Exception e) {
      j.setSuccess(false);
      j.setMsg("编辑失败");
      e.printStackTrace();
    }
    return j;
  }


  /**
   * 删除
   * 
   * @return
   */
  @RequestMapping(params = "doDelete", method = RequestMethod.GET)
  @ResponseBody
  public AjaxJson doDelete(@RequestParam(required = true, value = "id") String id) {
    AjaxJson j = new AjaxJson();
    try {
      fDOrderService.delete(id);
      j.setMsg("删除成功");
    } catch (Exception e) {
      j.setSuccess(false);
      j.setMsg("删除失败");
      e.printStackTrace();
    }
    return j;
  }

  /**
   * 批量删除数据
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "batchDelete", method = RequestMethod.POST)
  @ResponseBody
  public AjaxJson batchDelete(@RequestParam(required = true, value = "ids") String[] ids) {
    AjaxJson j = new AjaxJson();
    try {
      fDOrderService.batchDelete(ids);
      j.setMsg("批量删除成功");
    } catch (Exception e) {
      j.setSuccess(false);
      j.setMsg("批量删除失败");
      e.printStackTrace();
    }
    return j;
  }

  /**
   * Find store grid data
   * 
   * @return
   */
  @RequestMapping(params = "findGrid", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody
  public AjaxJson findGrid(@ModelAttribute DeliverVo deliverVo) {
    AjaxJson j = new AjaxJson();
    LOG.info("{}", deliverVo);
    try {
      List<OrderCountResult> list = fDQueryDao.getOrderCountWithDate(deliverVo);
      j.setObj(list);
      j.setMsg("成功");
    } catch (Exception e) {
      j.setSuccess(false);
      j.setMsg("失败");
      e.printStackTrace();
    }
    return j;
  }

  /**
   * Find store grid data
   * 
   * @return
   */
  @RequestMapping(params = "findBad", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody
  public AjaxJson findBad(@ModelAttribute DeliverVo deliverVo) {
    AjaxJson j = new AjaxJson();
    LOG.info("{}", deliverVo);
    try {
      List<OrderBadTemResult> list = fDQueryDao.getBadOrder(deliverVo);
      LinkedHashMap<Double, BadInfo> map = new LinkedHashMap<>();
      for (OrderBadTemResult or : list) {
        Double t = or.getTranstemperature();
        Integer gobad = or.getGobad();
        if (!map.containsKey(t)) {
          map.put(t, new BadInfo());
        }
        BadInfo info = map.get(t);
        if (gobad == 0) {
          info.addGoodcount();
        } else {
          info.addBadcount();
        } ;
      }
      ArrayList<Double> xdata = new ArrayList<>();
      ArrayList<Double> sdata = new ArrayList<>();
      ArrayList<JSONObject> tdata = new ArrayList<>();
      map.forEach((k, v) -> {
        xdata.add(k);
        sdata.add(v.getRate());
        JSONObject js = new JSONObject();
        js.put("temp", k);
        js.put("rate", v.getRate());
        tdata.add(js);
      });
      JSONObject res = new JSONObject();
      res.put("xdata", xdata);
      res.put("sdata", sdata);
      res.put("tdata", tdata);
      j.setObj(res);
      j.setMsg("成功");
    } catch (Exception e) {
      j.setSuccess(false);
      j.setMsg("失败");
      e.printStackTrace();
    }
    return j;
  }
  /**
   * Find store grid data
   * 
   * @return
   */
  @RequestMapping(params = "findBack", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody
  public AjaxJson findBack(@ModelAttribute DeliverVo deliverVo) {
    AjaxJson j = new AjaxJson();
    LOG.info("{}", deliverVo);
    try {
      List<OrderBackResult> list = fDQueryDao.getBack(deliverVo);
      j.setObj(list);
      j.setMsg("成功");
    } catch (Exception e) {
      j.setSuccess(false);
      j.setMsg("失败");
      e.printStackTrace();
    }
    return j;
  }

}

