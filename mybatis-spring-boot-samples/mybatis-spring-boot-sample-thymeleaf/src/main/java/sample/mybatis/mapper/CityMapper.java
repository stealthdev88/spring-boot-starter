/*
 *    Copyright 2015-2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package sample.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.scripting.thymeleaf.support.TemplateFilePathProvider;

import sample.mybatis.domain.City;

/**
 * @author Kazuki Shimizu
 */
@Mapper
public interface CityMapper {

  @Select("select id, name, state, country from city where id = /*[# mb:p='id']*/ 1 /*[/]*/")
  City findById(@Param("id") Long id);

  @Select("CityMapper-findByState.sql")
  City findByState(@Param("state") String state);

  City findByName(@Param("name") String name);

  @SelectProvider(TemplateFilePathProvider.class)
  City findByCountry(@Param("country") String country);

}
