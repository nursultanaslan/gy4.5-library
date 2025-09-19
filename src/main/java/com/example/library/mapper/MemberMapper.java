package com.example.library.mapper;

import com.example.library.dto.member.request.CreateMemberRequest;
import com.example.library.dto.member.response.GetByIdMemberResponse;
import com.example.library.dto.member.response.MemberResponse;
import com.example.library.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")//bu bileşen model olarak Springin IOC modeline gore kendini oluştursun
public interface MemberMapper {

    //Dışarıdan bu mappera erişim için
    //Interface sınıf oldugu icin automappera gidip MemberMapper classını oluşturmasını istiyorum
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    //Dönüş Tipi (Member) : target  //Oluşturmaya kaynak olacak parametreye de : source diyoruz (CreateMemberRequest)
    Member createMemberRequestToMember(CreateMemberRequest request);

    MemberResponse memberToCreateMemberRequest(Member member);

    GetByIdMemberResponse memberToGetByIdResponse(Member member);

    MemberResponse memberTorMemberResponse(Member member);

}
