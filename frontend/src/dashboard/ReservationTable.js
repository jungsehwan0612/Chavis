import React, { useState, useEffect } from 'react';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';

function createData(reservation_time, client_name, key, repaired_person, repaired_time) {

  var temp = key!=="NO"? key:"사용 안함";
  return { reservation_time, client_name, temp, repaired_person, repaired_time }

}

export default function ReservationTable() {

  const [orders, setOrders] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/Chavis/Reservation/list.do')
      .then(response => response.json())
      .then(orders => {
        setOrders(orders);
      });
  }, []);

  const rows = [];
  orders.forEach(order => {
    rows.push(createData(order['reservation_time'], order['client_name'], order['key'], order["repaired_person"], order['repaired_time']))
  })

  return (
    <React.Fragment>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell key="1">예약 시간</TableCell>
            <TableCell key="2">회원 이름</TableCell>
            <TableCell key="3">원격키</TableCell>
            <TableCell key="4">정비사 이름</TableCell>
            <TableCell key="5">작업 완료 시간</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map(row => (
            <TableRow>
              <TableCell key="1">{row.reservation_time}</TableCell>
              <TableCell key="2">{row.client_name}</TableCell>
              <TableCell key="3">{row.temp}</TableCell>
              <TableCell key="4">{row.repaired_person}</TableCell>
              <TableCell align="center" key="5">{row.repaired_time}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </React.Fragment>
  );
}