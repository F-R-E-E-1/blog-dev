package com.jucwang.service;

import com.jucwang.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {

    //保存标签
    Tag saveTag(Tag tag);

    //查询标签
    Tag getTag(Long id);

    //分页查询
    Page<Tag> listTag(Pageable pageable);

    //修改标签
    Tag updateTag(Long id,Tag tag);

    //删除标签
    void deleteTag(Long id);

    Tag getTagByName(String name);

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    List<Tag> listTop(Integer size);
}
