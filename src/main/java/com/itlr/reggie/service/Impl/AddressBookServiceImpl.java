package com.itlr.reggie.service.Impl;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-25-13:03
 */
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itlr.reggie.entity.AddressBook;
import com.itlr.reggie.mapper.AddressBookMapper;
import com.itlr.reggie.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}

