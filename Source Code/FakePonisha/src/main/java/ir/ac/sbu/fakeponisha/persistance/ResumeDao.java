package ir.ac.sbu.fakeponisha.persistance;

import ir.ac.sbu.fakeponisha.model.Resume;
import java.util.List;

public interface ResumeDao {

    /**
     *
     * @return
     */
    public List<Resume> getAllResumes();

    /**
     *
     * @param resumeId
     * @return
     */
    public Resume getResume(int resumeId);

    /**
     *
     * @param resume
     */
    public void insertResume(Resume resume);

    /**
     *
     * @param resume
     */
    public void updateResume(Resume resume);
}
