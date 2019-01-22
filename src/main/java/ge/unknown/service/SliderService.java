package ge.unknown.service;

import ge.unknown.dao.SliderDAO;
import ge.unknown.dto.SliderDTO;
import ge.unknown.entities.Slider;
import ge.unknown.enums.ESliderSection;
import ge.unknown.utils.pagination.PaginationAndFullSearchQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by MJaniko on 3/7/2017.
 */
@Service
public class SliderService {

    @Autowired
    private SliderDAO sliderDAO;

    @Transactional(readOnly = true)
    public PaginationAndFullSearchQueryResult<SliderDTO> getList(String searchExpression, String sortField, boolean isAscending, Integer pageNumber, int pageSize) {
        return sliderDAO.getPaginatedList(Slider.class, searchExpression,
                sortField, isAscending, pageNumber, pageSize).transform(SliderDTO.class);
    }

    @Transactional(readOnly = true)
    public List<Slider> getAll(){
        return sliderDAO.all();
    }

    @Transactional
    public Slider save(Slider slider) {
        if (slider.getId() != null) {
            return sliderDAO.update(slider);
        }
        return sliderDAO.create(slider);
    }

    @Transactional
    public boolean delete(Long id) {
        return sliderDAO.delete(id);
    }
}
