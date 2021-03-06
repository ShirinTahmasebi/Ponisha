package ir.ac.sbu.springponisha.service;

import ir.ac.sbu.springponisha.dao.model.Resume;
import java.util.List;

public interface ResumeManager {

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
