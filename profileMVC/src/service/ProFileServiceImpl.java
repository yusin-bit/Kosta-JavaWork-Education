package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import dto.ProFileDto;
import exception.ProfileAlreadyExistsException;
import exception.ProfileNotFoundException;

public class ProFileServiceImpl implements ProFileService {

    @Override
    public void saveprofile(ProFileDto profiledto) throws IOException, ProfileAlreadyExistsException {
        String name = profiledto.getName();
        File file = new File(name + ".txt");

        if (file.exists()) {
            throw new ProfileAlreadyExistsException("이미 저장된 프로필입니다");
        }

        int weight = profiledto.getWeight();
        int password = profiledto.getPassword();
        String str = weight + ":" + password;

        try (FileWriter fw = new FileWriter(file)) {
            fw.write(str);
        }
    }

    @Override
    public ProFileDto loadprofile(String name) throws IOException, ProfileNotFoundException {
        File file = new File(name + ".txt");

        if (!file.exists()) {
            throw new ProfileNotFoundException("파일을 찾을 수 없습니다");
        }

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            String readline = br.readLine();
            String[] data = readline.split(":");
            int weight = Integer.parseInt(data[0]);
            int password = Integer.parseInt(data[1]);

            return new ProFileDto(name, weight, password);
        }
    }

    @Override
    public void updateWeight(String name, int newWeight) throws IOException, ProfileNotFoundException {
        ProFileDto dto = loadprofile(name);
        File file = new File(name + ".txt");

        try (FileWriter fw = new FileWriter(file)) {
            fw.write(newWeight + ":" + dto.getPassword());
        }
    }

    @Override
    public void updatePassword(String name, int newPassword) throws IOException, ProfileNotFoundException {
        ProFileDto dto = loadprofile(name);
        File file = new File(name + ".txt");

        try (FileWriter fw = new FileWriter(file)) {
            fw.write(dto.getWeight() + ":" + newPassword);
        }
    }
}
