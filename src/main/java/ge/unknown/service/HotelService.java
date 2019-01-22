package ge.unknown.service;

import ge.unknown.dao.HotelDAO;
import ge.unknown.dto.HotelDTO;
import ge.unknown.entities.City;
import ge.unknown.entities.Hotel;
import ge.unknown.utils.SEOUtil;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MJaniko on 3/10/2017.
 */
@Service
public class HotelService {

    @Autowired
    private HotelDAO hotelDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<HotelDTO> getSearchList(
            String searchExpression,
            String sortField,
            boolean isAscending,
            Integer pageNumber,
            int pageSize,
            int starCount,
            int roomCount,
            int adultAmount,
            int childrenAmount,
            int ethernet,
            int restourant,
            int spaServices,
            int swimmingPool,
            int parking,
            int gym) {
        return hotelDAO.getPaginatedList(Hotel.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize,starCount,
                roomCount,adultAmount,childrenAmount,ethernet,
                restourant,spaServices,swimmingPool,parking,gym
        ).transform(HotelDTO.class);
    }

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<HotelDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize) {
        return hotelDAO.getPaginatedList(Hotel.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize).transform(HotelDTO.class);
    }


    @Transactional(readOnly = true)
    public List<Hotel> getHotelsByCity(Long id, City city){
        return hotelDAO.getHotelsByCity(id,city);
    }

    @Transactional(readOnly = true)
    public Hotel getById(Long id){
        return hotelDAO.find(id);
    }

    @Transactional
    public Hotel save(Hotel hotel) {
        hotel.setLinks(SEOUtil.generatedSEO(hotel.getDescription()));
        if (hotel.getId() != null) {
            return hotelDAO.update(hotel);
        }
        return hotelDAO.create(hotel);
    }

    @Transactional
    public boolean delete(Long id) {
        return hotelDAO.delete(id);
    }
}
