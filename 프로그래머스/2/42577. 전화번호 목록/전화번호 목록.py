def solution(phone_book):
    phone_book.sort()
    book_len = len(phone_book)
    for idx, number in enumerate(phone_book):
        i = 1
        len_num = len(number)
        while idx+i < book_len and phone_book[idx+i][:len_num] == number:
            # if phone_book[idx+i][:len_num] == number:
            return False
            i += 1
    return True