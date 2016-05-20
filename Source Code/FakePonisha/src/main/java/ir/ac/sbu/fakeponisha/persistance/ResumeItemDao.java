package ir.ac.sbu.fakeponisha.persistance;

import ir.ac.sbu.fakeponisha.model.ResumeItem;
import java.util.List;

public interface ResumeItemDao {

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
