package com.example.logintest.service;

import com.example.logintest.domain.Gril;
import com.example.logintest.repository.GrilRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.TableGenerator;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class GrilService {

    @Resource
    private GrilRepository grilRepository;

    /**
     * save、update、delete 方法需要绑定事务
     * @param
     * @return
     */
    public Gril findById(Long id){
        return grilRepository.getOne(id);
    }
    @Transactional
    public void deleteById(Long id){
        grilRepository.deleteById(id);
    }



   /* public List<Gril> find(String id, String name){
        return grilRepository.find(id,name);
    }*/

    public List<Gril> findAll(){
        return grilRepository.findAll();
    }
    @Transactional
    public Gril save(Gril gril){
        return grilRepository.save(gril);
    }
    @Transactional
    public void update(Gril gril){
        grilRepository.save(gril);
    }

    //模糊查询加上通配符
    public List<Gril> findByNameLike(String name){
        return grilRepository.findByNameLike("%" + name + "%");
    }

    public List<Gril> findByIdOrName(Long id, String name){
        return grilRepository.findByIdOrName(id, name);
    }
}
