package com.activity_join.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


public class ActivityJoinService {
	
	private ActivityJoin_interface dao;
	
	public ActivityJoinService() {
//		dao = new ActivityJoinJDBCDAO();
		dao = new ActivityJoinDAO();
	}
	
	public List<ActivityJoinVO> getActJoin(Map<String, String[]> map){
		return dao.getJoin(map);
	}
	
	
	public List<ActivityJoinVO> getactStateZero(Integer member_id){
		List<ActivityJoinVO> list = dao.getactStateZero(member_id);
		Timestamp now = new Timestamp(System.currentTimeMillis());
		for (ActivityJoinVO vo : list) {
			Timestamp activitySessionStart = vo.getActivitySessionStart();
			long durationTime = activitySessionStart.getTime() - now.getTime();
			vo.setCanCancel(durationTime >= 1000 * 60 * 60 * 24 * 14);
		}
		return list;
	}
	public List<ActivityJoinVO> getactStateOne(Integer member_id){
		return dao.getactStateOne(member_id);
	}
	public List<ActivityJoinVO> getactStateTwo(Integer member_id){
		return dao.getactStateTwo(member_id);
	}
	
    public ActivityJoinVO getOneActivityID(Integer activityOrderId) {
    	return dao.findByPrimaryKey(activityOrderId);
    }

    public void update(Integer activityOrderId) {
    	dao.update(activityOrderId);
    }
    
	public ActivityJoinVO addActivityOrder(ActivityJoinVO activityJoinVO) {
		dao.insert(activityJoinVO);  //成功到資料庫後
		return dao.findOrderById(activityJoinVO.getActivityOrderId());
	}

	public Map<String, Object> getPriceById(Integer activityId) {
    	return dao.findPriceById(activityId);
    }
	
	public Map<String, Object> getDateTimeByIdAndDate(Integer activityId, Timestamp date) {
    	return dao.findDateTimeByIdAndDate(activityId, date);
    }
	
//=========================================== Fei =========================================
	public List<ActivityJoinVO> getAll() {
		return dao.getAll();
	}

	public ActivityJoinVO staff_addActivityOrder(ActivityJoinVO activityJoinVO) {
		dao.insert(activityJoinVO);		
		return activityJoinVO;
	}
	
    public ActivityJoinVO updateActivityOrder(ActivityJoinVO activityJoinVO) {
    	dao.updateActivityOrder(activityJoinVO);    	
    	return activityJoinVO;
    }
    
	public List<ActivityJoinVO> getAll(Map<String, String[]> map) {
		
		return dao.getAll(map);
		
	}
}
