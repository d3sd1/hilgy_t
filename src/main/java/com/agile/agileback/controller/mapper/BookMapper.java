package com.agile.agileback.controller.mapper;

import com.agile.agileback.controller.dto.BookDTO;
import com.agile.agileback.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO bookToBookDTO(Book entity);
    Book bookDTOToBook(BookDTO dto);
}