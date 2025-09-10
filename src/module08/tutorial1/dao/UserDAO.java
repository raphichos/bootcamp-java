package module08.tutorial1.dao;

import module08.tutorial1.exception.EmptyStorageException;
import module08.tutorial1.exception.UserNotFoundException;
import module08.tutorial1.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private long nextId = 1L;

    private final List<UserModel> models = new ArrayList<>();

    public UserModel save(final UserModel model){
        model.setId(nextId++);
        models.add(model);
        return model;
    }

    public UserModel update(final UserModel model){
        var toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    public void delete(final long id) throws UserNotFoundException{
        var toDelete = findById(id);
        models.remove(toDelete);
    }

    public UserModel findById(final long id){
        verifyStorage();
        var message = String.format("Não existe o usuário com o id %s cadastrado", id);
        return models.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(message));
    }

    public List<UserModel> findAll(){
        List<UserModel> result = null;
        try {
            verifyStorage();
            result = models;
        }catch (EmptyStorageException ex){
            ex.printStackTrace();
            result = new ArrayList<>();
        }
        return result;
    }

    private void verifyStorage(){
        if (models.isEmpty()) throw new EmptyStorageException("O armazenamento está vazio");
    }

}
