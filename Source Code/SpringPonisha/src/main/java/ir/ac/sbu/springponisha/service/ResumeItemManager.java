package ir.ac.sbu.springponisha.service;

import ir.ac.sbu.springponisha.dao.model.ResumeItem;
import java.util.List;

public interface ResumeItemManager {

    /**
     *
     * @return
     */
    public List<ResumeItem> getAllResumeItems();

    /**
     *
     * @param resumeItemId
     * @return
     */
    public ResumeItem getResumeItem(int resumeItemId);

    /**
     *
     * @param resumeItem
     */
    public void insertResumeItem(ResumeItem resumeItem);

    /**
     *
     * @param resmueItem
     */
    public void updateResumeItem(ResumeItem resmueItem);
}
