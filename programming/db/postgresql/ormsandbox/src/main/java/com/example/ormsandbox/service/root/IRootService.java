package com.example.ormsandbox.service.root;

import com.example.ormsandbox.DTO.RootDTO;

public interface IRootService {
    RootDTO getRoot(int id);

    boolean insertRoot(RootDTO rootDTO);
}
