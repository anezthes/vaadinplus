declare module '*.css' {
  import { CSSResultGroup } from 'lit';
  const content: CSSResultGroup;
  export default content;
}
declare module '*.css?inline' {
  import type { CSSResultGroup } from 'lit';
  const content: CSSResultGroup;
  export default content;
}

declare module 'csstype' {
  interface Properties {
    [index: `--${string}`]: any;
  }
}
