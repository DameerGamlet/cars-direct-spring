import { CarHeader } from "@/components/header/car-header";
import { HomeCarDirectPage } from "@/components/home-car-direct-page";

import "bootstrap/dist/css/bootstrap.min.css";
import "../styles/globals.css";

import Head from "next/head";

export default function Home() {
  return (
    <>
      <CarHeader />
      <HomeCarDirectPage />
    </>
  );
}
