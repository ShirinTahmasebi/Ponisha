package ir.ac.sbu.springponisha.service.impl;

import ir.ac.sbu.springponisha.dao.ResumeItemDao;
import ir.ac.sbu.springponisha.dao.model.ResumeItem;
import ir.ac.sbu.springponisha.service.ResumeItemManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeItemManagerImpl implements ResumeItemManager{

    @Autowired
    ResumeItemDao resumeItemDao;
   
    @Override
    public List<ResumeItem> getAllResumeItems() {
        return resumeItemDao.getAllResumeItems();
    }

    @Override
    public ResumeItem getResumeItem(int resumeItemId) {
        return resumeItemDao.getResumeItem(resumeItemId);
    }

    @Override
    public void insertResumeItem(ResumeItem resumeItem) {
        resumeItemDao.insertResumeItem(resumeItem);
    }

    @Override
    public void updateResumeItem(ResumeItem resmueItem) {
        resumeItemDao.updateResumeItem(resmueItem);
    }
    
}
