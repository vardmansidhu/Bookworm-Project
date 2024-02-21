import React, { useEffect, useState } from "react";
import MyCarousel from "./MyCarousel";
import { useCookies } from "react-cookie";

export default function Home() {
  const [cookies, setCookie] = useCookies(["user"]);

  return (
    <div>
      <MyCarousel />
      {cookies.user ? (
        <>
          <h1>Trending Products</h1>
          <h1>Upcoming</h1>
        </>
      ) : (
        <>
          <h1>logged out</h1>
        </>
      )}
    </div>
  );
}
