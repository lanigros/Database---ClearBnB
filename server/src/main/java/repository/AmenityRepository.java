//package repository;
//
//import java.util.List;
//import java.util.Optional;
//import javax.persistence.EntityManager;
//import model.Amenity;
//import repositoryinterface.AmenityRepositoryInterface;
//
//public class AmenityRepository implements AmenityRepositoryInterface {
//
//    EntityManager entityManager;
//
//    @Override
//    public Optional<Amenity> findById(String id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Amenity> findAll() {
//        return null;
//    }
//
//    public AmenityRepository(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//}
