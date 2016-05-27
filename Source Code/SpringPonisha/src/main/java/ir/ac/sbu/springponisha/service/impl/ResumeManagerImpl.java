/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.springponisha.service.impl;

import ir.ac.sbu.springponisha.dao.ResumeDao;
import ir.ac.sbu.springponisha.dao.model.Resume;
import ir.ac.sbu.springponisha.service.ResumeManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResumeManagerImpl implements ResumeManager {

    @Autowired
    private ResumeDao resumeDao;

    @Override
    public List<Resume> getAllResumes() {
        return resumeDao.getAllResumes();
    }

    @Override
    public Resume getResume(int resumeId) {
        return resumeDao.getResume(resumeId);
    }

    @Override
    @Transactional
    public void insertResume(Resume resume) {
        resumeDao.insertResume(resume);
    }

    @Override
    @Transactional
    public void updateResume(Resume resume) {
        resumeDao.updateResume(resume);
    }

}
