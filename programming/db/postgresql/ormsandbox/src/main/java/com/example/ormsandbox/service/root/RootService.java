package com.example.ormsandbox.service.root;

import com.example.ormsandbox.DTO.RootDTO;
import com.example.ormsandbox.Entity.ChildA;
import com.example.ormsandbox.Entity.ChildB;
import com.example.ormsandbox.Entity.Root;
import com.example.ormsandbox.repository.IRootRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RootService implements IRootService {

    @Autowired
    IRootRepository repository;

    @Autowired
    ModelMapper mapper;


    public RootService(){};

    @Override
    public RootDTO getRoot(int id) {
        Root root = repository.findRootById(id);
        if (root == null) throw
        RootDTO output = mapper.map(root, RootDTO.class);
        return output;
    }

    @Override
    public boolean insertRoot(RootDTO rootDTO) {
        Root root = new Root();
        ChildA childA = new ChildA();
        ChildB childB = new ChildB();

        childA.setId(rootDTO.getChildA().getId());
        childB.setId(rootDTO.getChildB().getId());

        root.setId(rootDTO.getId());
        root.setChildA(childA);
        root.setChildB(childB);
        repository.save(root);
        return true;
    }
}
