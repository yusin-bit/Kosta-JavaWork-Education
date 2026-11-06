package service;

import java.io.IOException;

import dto.ProFileDto;
import exception.ProfileAlreadyExistsException;
import exception.ProfileNotFoundException;

public interface ProFileService {

    void saveprofile(ProFileDto profiledto) throws IOException, ProfileAlreadyExistsException;

    ProFileDto loadprofile(String name) throws IOException, ProfileNotFoundException;

    void updateWeight(String name, int newWeight) throws IOException, ProfileNotFoundException;

    void updatePassword(String name, int newPassword) throws IOException, ProfileNotFoundException;
}
