package com.fresh.core.web;

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

import com.fresh.core.entity.FDGoodsEntity;
import com.fresh.core.entity.FDStoreEntity;
import com.fresh.core.entity.FDStoreItemsEntity;
import com.fresh.core.model.DateVo;
import com.fresh.core.service.FDStoreItemsService;

 /**
 * 描述：商品表
 * 
 * @author: www.jeecg.org
 * @since：2019年03月27日 17时33分21秒 星期三
 * @version:1.0
 */
@Controller
@RequestMapping("/fresh/fDStoreItems")
public class FDStoreItemsController extends BaseController{
  @Autowired
  private FDStoreItemsService fDStoreItemsService;
  
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute FDStoreItemsEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	LOG.info(request, " back list");
			 	//分页数据
				MiniDaoPage<FDStoreItemsEntity> list =  fDStoreItemsService.getAll(query,pageNo,pageSize);
				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("fDStoreItems",query);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "fresh/core/fDStoreItems-list.vm";
				ViewVelocity.view(request,response,viewName,velocityContext);
			} catch (Exception e) {
				e.printStackTrace();
			}
}

	 /**
	  * 详情
	  * @return
	  */
	@RequestMapping(params="toDetail",method = RequestMethod.GET)
	public void fDStoreItemsDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "fresh/core/fDStoreItems-detail.vm";
			FDStoreItemsEntity fDStoreItems = fDStoreItemsService.get(id);
			velocityContext.put("fDStoreItems",fDStoreItems);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 String viewName = "fresh/core/fDStoreItems-add.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute FDStoreItemsEntity fDStoreItems){
		AjaxJson j = new AjaxJson();
		try {
			fDStoreItemsService.insert(fDStoreItems);
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
	 * @return
	 */
	@RequestMapping(params="toEdit",method = RequestMethod.GET)
	public void toEdit(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
			 VelocityContext velocityContext = new VelocityContext();
			 FDStoreItemsEntity fDStoreItems = fDStoreItemsService.get(id);
			 velocityContext.put("fDStoreItems",fDStoreItems);
			 String viewName = "fresh/core/fDStoreItems-edit.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute FDStoreItemsEntity fDStoreItems){
		AjaxJson j = new AjaxJson();
		try {
			fDStoreItemsService.update(fDStoreItems);
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
	 * @return
	 */
	@RequestMapping(params="doDelete",method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson doDelete(@RequestParam(required = true, value = "id" ) String id){
			AjaxJson j = new AjaxJson();
			try {
				fDStoreItemsService.delete(id);
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
	 * @param ids
	 * @return
	 */
	@RequestMapping(params="batchDelete",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson batchDelete(@RequestParam(required = true, value = "ids") String[] ids) {
		AjaxJson j = new AjaxJson();
		try {
			fDStoreItemsService.batchDelete(ids);
			j.setMsg("批量删除成功");
		} catch(Exception e) {
			j.setSuccess(false);
			j.setMsg("批量删除失败");
			e.printStackTrace();
		}
		return j;
	}
	
	/**
     * Find store grid data
     * @return
     */
    @RequestMapping(params = "findGrid",method ={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public AjaxJson findGrid(
        @ModelAttribute DateVo dateVo,
        @ModelAttribute FDGoodsEntity goods,
        @ModelAttribute FDStoreEntity store,
        @ModelAttribute FDStoreItemsEntity fDStoreItems){
        AjaxJson j = new AjaxJson();
        LOG.info("{}",dateVo);
        LOG.info("{}",goods);
        LOG.info("{}",store);
        LOG.info("{}",fDStoreItems);
        try {
            j.setMsg("保存成功");
        } catch (Exception e) {
            j.setSuccess(false);
            j.setMsg("保存失败");
            e.printStackTrace();
        }
        return j;
    }

}

